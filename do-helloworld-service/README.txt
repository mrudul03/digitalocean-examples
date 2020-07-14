
docker build -t mrudul03/do-helloworld-service:v01 .
docker run -p 8080:8080 mrudul03/do-helloworld-service:v01
http://localhost:8080/api/helloservice/mrudul123

docker push mrudul03/do-helloworld-service:v01

kubectl create namespace helloworld
kubectl get namespace

kubectl apply -f deployment.yaml -n helloworld
kubectl get deploy -n helloworld

kubectl apply -f service.yaml -n helloworld
kubectl get svc -n helloworld

http://104.248.108.110/api/helloservice/mrudul123

kubectl delete svc helloworld-svc -n helloworld
kubectl delete deployment helloworld-dep -n helloworld
kubectl delete configmap message-config -n helloworld

kubectl delete ingress helloworld-ingress -n helloworld

http://helloworld.cloudeira.com/api/helloservice/mrudul123

https://helloworld.cloudeira.com/api/helloservice/mrudul123
