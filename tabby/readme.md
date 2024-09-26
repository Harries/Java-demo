## deploy local llm
```shell
docker run -it --gpus all  -p 8080:8080 -v $HOME/.tabby:/data registry.tabbyml.com/tabbyml/tabby serve --model StarCoder-1B --chat-model Qwen2-1.5B-Instruct --device cuda
```

## Registering Accounts
After deploying Tabby, you will need to register an account on your server to access the instance. Open the homepage by the url you displayed in startup logs, e.g. http://localhost:8080.

##  Creating an Admin Account
The first registered account after deployment will be the admin account and will be granted the owner role.

## Connect IDE / Editor Extensions