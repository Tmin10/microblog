# -*- mode: ruby -*-
# vi: set ft=ruby :

Vagrant.configure("2") do |config|

  config.vm.box = "ubuntu/bionic64"
  
  config.vm.provider "virtualbox" do |v|
	  v.memory = 2048
	  v.cpus = 2
  end
  
  config.vm.provision "docker",
	images: ["strapdata/elassandra", "kibana:7.4.0"]
	
  config.vm.provision "shell", inline: <<-SHELL
    apt-get update
    apt install -y python-pip
	pip install docker
  SHELL
  
  config.vm.provision "ansible_local" do |ansible|
    ansible.playbook = "playbook.yml"
  end

  config.vm.network "forwarded_port", guest: 9042, host: 9042

end
