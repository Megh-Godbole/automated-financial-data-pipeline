#!/bin/bash

# Variables
DATE=$(date "+%Y-%m-%d_%H-%M-%S")
BACKUP_DIR="$HOME/db_backups"
LOG_FILE="status.log"
DB_NAME="TreasuryDB"

mkdir -p $BACKUP_DIR

echo "[$DATE] Starting data fetch..." >> $LOG_FILE

# Activate virtual environment
source venv/bin/activate

# Run Python script
python data_fetcher.py

echo "[$DATE] Data fetch completed." >> $LOG_FILE

# Backup database
mysqldump -u root $DB_NAME > $BACKUP_DIR/TreasuryDB_$DATE.sql

echo "[$DATE] Backup completed." >> $LOG_FILE
echo "--------------------------------------" >> $LOG_FILE
