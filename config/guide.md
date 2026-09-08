# file này có thể để trong thư mục .vscode hoặc một thư mục bất kì trong project ví du: config/mcp.json
#thư mục này sẽ chứa toàn bộ các file cấu hình cho kết nối MCP
 chứa các thông tin kết nối để các data khác nhau. nếu chỉ 1-5 cái databse thì mình sẽ có thể 
 cấu hình cụ thể biến môi trường trong windown
 WASTE_SQL_SERVER=server01
WASTE_SQL_DATABASE=waste
WASTE_SQL_USER=copilot_waste
WASTE_SQL_PASSWORD=xxxx

MDM_SQL_SERVER=server02
MDM_SQL_DATABASE=mdm
MDM_SQL_USER=copilot_mdm
MDM_SQL_PASSWORD=yyyy

và định nghĩa file mcp.json
{
  "servers": {
    "waste-db": {
      "command": "python",
      "args": ["mcp/sqlserver_server.py"],
      "env": {
        "SQL_SERVER": "${env:WASTE_SQL_SERVER}",
        "SQL_DATABASE": "${env:WASTE_SQL_DATABASE}",
        "SQL_USER": "${env:WASTE_SQL_USER}",
        "SQL_PASSWORD": "${env:WASTE_SQL_PASSWORD}"
      }
    },

    "mdm-db": {
      "command": "python",
      "args": ["mcp/sqlserver_server.py"],
      "env": {
        "SQL_SERVER": "${env:MDM_SQL_SERVER}",
        "SQL_DATABASE": "${env:MDM_SQL_DATABASE}",
        "SQL_USER": "${env:MDM_SQL_USER}",
        "SQL_PASSWORD": "${env:MDM_SQL_PASSWORD}"
      }
    }
  }
}

2. tuy nhiên nếu nheieuf cơ sở dữ liệu hơn thì nên đưa toàn bộ vào file configues

my-project/
│
├── .github/
│   ├── agents/
│   │   ├── main.agent.md
│   │   ├── developer.agent.md
│   │   └── reviewer.agent.md
│   │
│   └── skills/
│       └── database/
│           └── SKILL.md
│
├── .vscode/
│   └── mcp.json
│
├── mcp/
│   └── database_mcp.py
│
├── config/
│   ├── config.example.json       ← COMMIT
│   │
│   ├── dev/
│   │   ├── database.json        ← KHÔNG COMMIT
│   │   └── secret.env           ← KHÔNG COMMIT
│   │
│   ├── test/
│   │   ├── database.json        ← KHÔNG COMMIT
│   │   └── secret.env           ← KHÔNG COMMIT
│   │
│   └── prod/
│       ├── database.json        ← KHÔNG COMMIT
│       └── secret.env           ← KHÔNG COMMIT
│
└── .gitignore



config/dev/database.json
{
  "environment": "dev",

  "databases": {
    "waste": {
      "type": "sqlserver",
      "host": "192.168.1.10",
      "port": 1433,
      "database": "WasteDB",
      "username": "copilot_waste"
    },

    "mdm": {
      "type": "sqlserver",
      "host": "192.168.1.11",
      "port": 1433,
      "database": "MDMDB",
      "username": "copilot_mdm"
    }
  }
}


nhưng không cung cấp passs

.gitignore

Bạn cấu hình:

# Environment database configuration
/config/dev/database.json
/config/dev/secret.env

/config/test/database.json
/config/test/secret.env

/config/prod/database.json
/config/prod/secret.env


Password được lấy từ secret.env

Bạn có thể để MCP đọc secret riêng.

Ví dụ:

config/dev/secret.env
WASTE_DB_PASSWORD=abc123
MDM_DB_PASSWORD=xyz789