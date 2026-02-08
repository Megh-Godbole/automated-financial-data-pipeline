# Automated Financial Data Pipeline

A multi-language automated data pipeline that fetches real-time financial exchange rates, processes them, stores them in MySQL, and performs automated backups using shell scripting.

---

## Tech Stack
- Python (ETL, API integration)
- Java (enterprise-style processing & JDBC access)
- MySQL (relational database)
- Bash / Shell Scripting (automation & backups)
- Git & GitHub (version control)

---

## Architecture Overview

API (Exchange Rates)
        ↓
     Python ETL
        ↓
      MySQL DB
        ↓
     Java Processor
        ↓
Shell Automation + Backup

---

## Project Structure

```
automated-financial-data-pipeline/
│
├── database/
│   ├── schema.sql
│   └── seed.sql
│
├── python/
│   ├── data_fetcher.py
│   ├── db_connector.py
│   └── requirements.txt
│
├── java/
│   ├── src/main/java/com/pipeline/
│   │   ├── CurrencyProcessor.java
│   │   └── MySQLClient.java
│   └── pom.xml
│
├── shell/
│   ├── run_pipeline.sh
│   ├── backup_db.sh
│   └── scheduler.cron
│
├── logs/
│   └── pipeline.log
│
└── README.md
```

---

## Prerequisites
- macOS or Linux
- Python 3.9+
- Java 11+
- MySQL 8+
- Maven
- Git

---

## Setup Instructions

### 1. Clone Repository
```
git clone https://github.com/Megh-Godbole/automated-financial-data-pipeline.git  
cd automated-financial-data-pipeline
```

---

### 2. Database Setup (MySQL)

Start MySQL:
```
brew services start mysql
```

Create schema and seed data:
```
mysql -u root
SOURCE database/schema.sql;
SOURCE database/seed.sql;
```

Verify:
```
USE TreasuryDB;
SELECT * FROM ExchangeRates;
```

---

### 3. Python Setup (ETL Layer)

Create and activate virtual environment:
```
python3 -m venv venv
source venv/bin/activate
```

Install dependencies:
```
pip install -r python/requirements.txt
```

Run ETL script:
```
python python/data_fetcher.py
```

---

### 4. Java Setup (Processing Layer)

Build Java project:
```
cd java
mvn clean package
cd ..
```

Run Java database reader:
```
java -cp java/target/classes com.pipeline.MySQLClient
```

Run Java processor:
```
java -cp java/target/classes com.pipeline.CurrencyProcessor
```

---

### 5. Shell Automation

Make scripts executable:
```
chmod +x shell/*.sh
```

Run full pipeline:
```
cd shell
./run_pipeline.sh
```

Run database backup:
```
./backup_db.sh
```

Check logs:
```
cat logs/pipeline.log
```

---

## Scheduling (Cron Example)

```
0 18 * * * /full/path/shell/run_pipeline.sh
0 19 * * * /full/path/shell/backup_db.sh
```

---

## Key Features
- Real-time financial data ingestion using REST APIs
- Modular Python ETL pipeline
- Enterprise-style Java processing with JDBC
- Automated MySQL backups using mysqldump
- Shell scripting for orchestration and logging
- Production-style project structure for GitHub

---

## Resume Summary

Automated Financial Data Pipeline  
Designed and implemented a production-style data pipeline using Python, Java, MySQL, and Bash to ingest, process, persist, and back up real-time financial data with scheduling and logging.

---

## License
MIT
