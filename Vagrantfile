# -*- mode: ruby -*-
# vi: set ft=ruby :

Vagrant.configure("2") do |config|

  config.vm.box = "ubuntu/bionic64"
  
  config.vm.provider "virtualbox" do |v|
	  v.memory = 2048
	  v.cpus = 2
  end

  config.vm.network "forwarded_port", guest: 9042, host: 9042
  config.vm.network "forwarded_port", guest: 9200, host: 9200

  config.vm.provision "docker",
	images: ["strapdata/elassandra"]
	
  config.vm.provision "shell", inline: <<-SHELL
    apt-get update
    apt install -y python3-pip
	pip3 install -r /vagrant/requirements.txt
	python3 /vagrant/twitter_accounts/runme.py
  SHELL
  
  config.vm.provision "ansible_local" do |ansible|
    ansible.playbook = "playbook.yml"
  end

  config.vm.provision "shell", inline: <<-SHELL
    docker cp /vagrant/initial.cql elassandra:/tmp/
    docker exec -i elassandra cqlsh -f /tmp/initial.cql
    curl -XPUT -H 'Content-Type: application/json' http://localhost:9200/microblog -d'{"mappings":{"blog_records":{"discover":".*"}}}'
  SHELL

   config.vm.provision "shell", inline: "docker container start elassandra", run: 'always'

end
