import requests
import pandas as pd

URL = "http://localhost:8080/actions/export"

def load_actions():
    res = requests.get(URL)
    res.raise_for_status()
    return pd.DataFrame(res.json())

if __name__ == "__main__":
    df = load_actions()
    print(df.head())
    print("\n컬럼 목록:", df.columns.tolist())

