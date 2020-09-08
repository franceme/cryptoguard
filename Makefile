default:: run

#region Commands
docker:
	@$(info Build the Docker file)
	@docker build -t cryptoguard .

live:
	@$(info Running the Docker file)
	#This exposes port 9000 from the host machine to port 8888 within the docker machine
	@docker run -p 9000:8888 -ti cryptoguard /bin/bash

kill:
	@$(info Killing all the Dockerfiles)
	@-docker kill $$(docker ps -q)
	@-docker rm $$(docker ps -a -q)
	@-docker rmi $$(docker images -q)

run:
	@$(info Running the juypter notebook)
	@jupyter lab --ip=127.0.0.1 --port=9876
#endregion
