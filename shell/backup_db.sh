#!/bin/bash

DATE=$(date "+%Y-%m-%d_%H-%M-%S")
BACKUP_DIR="../backups"
LOG_FILE="../logs/pipeline.log"

mkdir -p $BACKUP_DIR

mysqldump -u root TreasuryDB > $BACKUP_DIR/treasury_$DATE.sql

echo "[$DATE] Database backup completed" >> $LOG_FILE
