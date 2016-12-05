## Cloud Deployment Steps

## Compile, Run and Package the app(server)
    Note: The below make commands can be found in the Makefile (available @ Project\CatchMeIfUCan\GameService-Cloud)

     make compile
     make run       // service starts at localhost ex: http://localhost:8081/
    
## Build Docker Image and Push the Image to Docker Cloud 
    Note: Must have an DockerHub account

     sudo make docker-build
     sudo make docker-run        // service starts at docker container ex: http://172.17.0.2:8081/
    

     sudo docker login -u <usename> -p <password>
     sudo docker push <imagename>:<tagname>
        
## Create Node/Node Cluster and Run the service on the Cloud(AWS)
    Note: Must have an Amazon AWS account, create I AM `role`, attach EC2 Full Access Policy to it and Launch an EC2 free-tier instance.

    Then one must link Docker Cloud and Amazon AWS following the link below,
     https://docs.docker.com/docker-cloud/infrastructure/link-aws/

    And, to create node and starting the service, use the below link,
     http://collabnix.com/archives/1064
     
    
    
  