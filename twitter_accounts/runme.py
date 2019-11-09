import glob
import xml.etree.ElementTree as ET

from dateutil.parser import parse

NS = {"dc": "http://purl.org/dc/elements/1.1/"}
INSERT_TEMPLATE = """INSERT INTO blog_records (user_name, created_at, blog_text, ip_address, useragent)
VALUES ('{}', minTimeuuid('{}'), '{}', '127.0.0.1', 'None');\n"""


def main():
    files = [f for f in glob.glob("./*.xml")]
    statuses = []
    for f in files:
        tree = ET.parse(f)
        root = tree.getroot()
        for status in root[0].findall("item"):
            statuses.append(
                {
                    "creator": clean_creator_name(status.find("dc:creator", NS).text),
                    "text": status.find("title").text,
                    "date": parse(status.find("pubDate").text),
                }
            )
    save_cassandra_dump(statuses)


def clean_creator_name(name):
    return name[3:-1]


def save_cassandra_dump(statuses):
    f = open("out.cql", "w+", encoding="utf8")
    for status in statuses:
        f.write(
            INSERT_TEMPLATE.format(
                status["creator"], status["date"], status["text"].replace("'", "''")
            )
        )
    f.close()


if __name__ == "__main__":
    main()
