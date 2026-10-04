# Redis-Cache

## Free Redis DB

1. Upstash
2. Redis Cloud

## For Production

1. ElastiCache - AWS
2. Azure Cache for Redis - Azure
3. Memorystore - GCP

## Spring Boot Configuration

Add the following to `application.properties`:

```properties
spring.data.redis.host=localhost
spring.data.redis.port=6379
```

## Run Redis Locally (Windows)

1. Install WSL (run in PowerShell as Administrator, then restart):

   ```bash
   wsl --install
   ```

2. Open the WSL terminal (Ubuntu) and install Redis:

   ```bash
   sudo apt update
   sudo apt install redis-server
   ```

3. Start the Redis server:

   ```bash
   sudo service redis-server start
   ```

4. Open the Redis CLI:

   ```bash
   redis-cli
   ```

## Redis CLI Commands

```bash
set key value    # store a value
get key          # read a value
del key          # delete a key
keys *           # list all keys
```