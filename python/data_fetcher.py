import requests
import mysql.connector
from datetime import datetime

# API URL
API_URL = "https://open.er-api.com/v6/latest/USD"

# MySQL connection
db = mysql.connector.connect(
    host="localhost",
    user="root",
    password="",   # add password if you set one
    database="TreasuryDB"
)

cursor = db.cursor()

# Fetch data
response = requests.get(API_URL)
data = response.json()

# Example conversion
usd_to_cad = data["rates"]["CAD"]
converted_amount = 100 * usd_to_cad  # example calculation

# Insert into database
sql = """
INSERT INTO ExchangeRates (currency_pair, rate, timestamp)
VALUES (%s, %s, %s)
"""

values = ("USD/CAD", usd_to_cad, datetime.now())

cursor.execute(sql, values)
db.commit()

print(f"Inserted USD/CAD rate: {usd_to_cad}")
print(f"100 USD = {converted_amount:.2f} CAD")

cursor.close()
db.close()
import requests
from datetime import datetime
from db_connector import get_connection

API_URL = "https://open.er-api.com/v6/latest/USD"

def fetch_rates():
    response = requests.get(API_URL, timeout=10)
    response.raise_for_status()
    return response.json()["rates"]

def insert_rate(pair, rate):
    conn = get_connection()
    cursor = conn.cursor()

    sql = """
        INSERT INTO ExchangeRates (currency_pair, rate, source)
        VALUES (%s, %s, %s)
    """
    cursor.execute(sql, (pair, rate, "python-api"))
    conn.commit()

    cursor.close()
    conn.close()

if __name__ == "__main__":
    rates = fetch_rates()
    usd_cad = rates["CAD"]

    insert_rate("USD/CAD", usd_cad)
    print(f"[Python] USD/CAD inserted: {usd_cad}")
