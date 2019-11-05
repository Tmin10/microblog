//START of SO copy-paste
//https://stackoverflow.com/questions/17571100/how-to-extract-timestamp-from-uuid-v1-timeuuid-using-javascript
//user contributions licensed under cc by-sa 4.0 with attribution required.
get_time_int = function (uuid_str) {
    var uuid_arr = uuid_str.split( '-' ),
        time_str = [
            uuid_arr[ 2 ].substring( 1 ),
            uuid_arr[ 1 ],
            uuid_arr[ 0 ]
        ].join( '' );
    return parseInt( time_str, 16 );
};

get_date_obj = function (uuid_str) {
    var int_time = this.get_time_int( uuid_str ) - 122192928000000000,
        int_millisec = Math.floor( int_time / 10000 );
    return new Date( int_millisec );
};
//END of SO copy-paste

var request = new XMLHttpRequest();
request.open('GET', '/record/list');
request.onload = (event) => {
    var data = JSON.parse(request.responseText);
    data.forEach((record) => {
        document.getElementById("records").innerHTML += `${record.blogRecordKey.userName} (${get_date_obj(record.blogRecordKey.createdAt).toLocaleString()}): ${record.blogText} \r\n`;
    });
};
request.send();