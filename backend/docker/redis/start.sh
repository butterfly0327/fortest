#!/usr/bin/env bash
set -euo pipefail

# docker compose(v2) 우선, 없으면 docker-compose(v1) 사용
if docker compose version >/dev/null 2>&1; then
  DC="docker compose"
else
  DC="docker-compose"
fi

$DC --env-file .env up -d
$DC ps

echo ""
echo "✅ Redis started!"
echo "   Host: 127.0.0.1"
echo "   Port: 6379"
echo "   Password: (see .env)"
echo ""
echo "Test:"
echo "  redis-cli -h 127.0.0.1 -p 6379 -a \"$(grep REDIS_PASSWORD .env | cut -d= -f2)\" ping"
