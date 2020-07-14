
docker build -t mrudul03/do-customer-service:v03 .
docker run -p 8080:8080 mrudul03/do-customer-service:v02
http://localhost:8080/api/customerservice/customers

docker push mrudul03/do-customer-service:v03

kubectl create namespace customer
kubectl get namespace

kubectl apply -f external-db.yaml -n customer
kubectl apply -f do-secret.yaml -n customer

kubectl apply -f deployment.yaml -n customer
kubectl get deploy -n customer

kubectl apply -f service.yaml -n customer
kubectl apply -f amb-customer-service -n customer
kubectl get svc -n customer

kubectl apply -f customer-ingress.yaml

kubectl delete svc customer-svc -n customer
kubectl delete deployment customer-dep -n customer
kubectl delete configmap customer-config -n customer

kubectl delete ingress customer-ingress -n customer

~~~~~~~~~~~~~~~~~~~~~~~
curl http://customer.cloudeira.com/api/customerservice/customers
curl http://customer.cloudeira.com/api/customerservice/customers/1

curl -v -X POST http://customer.cloudeira.com/api/customerservice/customers -H "Content-type:application/json" -d "{\"firstName\":\"ABC\", \"lastName\":\"ABC DEF\"}"

## encode
echo -n "STRING" | base64
## decode
echo 'YmRiaGNpNnU4cTMxZW85cw==' | base64 -D



