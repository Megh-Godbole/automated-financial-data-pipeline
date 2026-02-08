#!/bin/bash
set -e

echo "[Shell] Starting pipeline..."

source ../venv/bin/activate

python ../python/data_fetcher.py
java -cp ../java/target/classes com.pipeline.CurrencyProcessor

echo "[Shell] Pipeline completed"
