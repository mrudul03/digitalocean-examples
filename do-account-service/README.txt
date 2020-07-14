

docker build -t mrudul03/do-account-service:v02 .
docker run -p 8080:8080 mrudul03/do-account-service:v02
http://localhost:8080/api/accountservice/accounts

docker push mrudul03/do-account-service:v02

kubectl create namespace account
kubectl get namespace

kubectl apply -f deployment.yaml -n account
kubectl get deploy -n account

kubectl apply -f service.yaml -n account
kubectl get svc -n account

kubectl apply -f account-ingress.yaml -n account
kubectl get ingress -n account

curl http://account.cloudeira.com/api/accountservice/accounts

kubectl delete svc account-svc -n account
kubectl delete deployment account-dep -n account
kubectl delete configmap account-config -n account

kubectl delete ingress account-ingress -n account

~~~~~~~~~~~~~~~~~~~~~~~

