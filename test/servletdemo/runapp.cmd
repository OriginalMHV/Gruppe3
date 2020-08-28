::Run this as admin from folder where dockerfile is located

::Build The image
docker build -t roro .

::Force stop existing container (it keeps executing if this one does not exist)
docker kill roro

::Remove existing container (it keeps executing if this one does not exist)

#docker rm roro

::Have some coffee (in seconds), gives docker time to remove the container before starting the new one
TIMEOUT 2

::Start the new Container
docker run --name roro -d -p 4848:4848 -p 8080:8080 roro

:: run browser
start chrome http://localhost:8080/Docker-File-1.0-SNAPSHOT/index.html
::start chrome http://localhost:8080/Docker-File-1.0-SNAPSHOT/index.html

::Note the different way of starting edge
::start microsoft-edge:http://localhost:8080/Docker-File-1.0-SNAPSHOT/index.html