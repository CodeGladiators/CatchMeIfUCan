[![Stories in Done](https://badge.waffle.io/CodeGladiators/CatchMeIfUCan.png?label=done&title=Done)](https://waffle.io/CodeGladiators/CatchMeIfUCan)

[[  http://j.gifs.com/y87jP7.gif | height = 100px ]]


Game Music-
* In Action by veezyn (c) copyright 2016 Licensed under a Creative Commons Attribution Noncommercial  (3.0) license. http://dig.ccmixter.org/files/veezyn/54448 Ft: Spinningmerkaba ,  Hans Atom

# CatchMeIfUCan
Help the police catch the biggest thief of the world

## *Features* 

1. Single and Multiplayer modes
2. Excellent tutorial for binary search


## *Basic Story :*
The game characters are a thief who is looting houses around a city according to the wealth of the people in the homes, the objective being to
catch the thief before he steals all the wealth. There will be multiple levels in the game to slowly teach  the person playing it to search for the
thief in a logical manner instead of relying on luck.

This is a multiplayer turn based game which pits one player against another through a maze of houses in which a thief is doing utmost to empty
of wealth. The task is to apply knowledge of binary search algorithm to sort through the houses and catch the thief before he makes away with all
the money. Unlike other games in which luck decides, here whichever player has the most knowledge wins.    

## *Deployment Strategy :*

### Compile, Run and Package the app(server)
    Note: The below make commands can be found in the Makefile (available @ Project\CatchMeIfUCan\GameService-Cloud)

     make compile
     make run       // service starts at localhost ex: http://localhost:8081/
    
### Build Docker Image and Push the Image to Docker Cloud 
    Note: Must have an DockerHub account

     sudo make docker-build
     sudo make docker-run        // service starts at docker container ex: http://172.17.0.2:8081/
    

     sudo docker login -u <usename> -p <password>
     sudo docker push <imagename>:<tagname>
        
### Create Node/Node Cluster and Run the service on the Cloud(AWS)
    Note: Must have an Amazon AWS account, create I AM `role`, attach EC2 Full Access Policy to it and Launch an EC2 free-tier instance.

    Then one must link Docker Cloud and Amazon AWS following the link below,
     https://docs.docker.com/docker-cloud/infrastructure/link-aws/

    And, to create node and starting the service, use the below link,
     http://collabnix.com/archives/1064

## *Further Developemnt*

1. Add more levels 
2. Add button to restart server
3. Enhanced user interface
