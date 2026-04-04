# サンプルBBS

## どんなアプリ？
フロントエンド、バックエンドを通しで動かす為の実験場アプリ。

## 構成
 - フロントエンド
   - nginx: stable
   - React: 19
 - バックエンド
   - java: 21
 - DB
   - MySQL: 9.6
 

## 手順
### バックエンドのビルド
```shell
cd backend
```
```shell
./gradlew clean build --console=verbose
```

```shell
./gradlew build --console=verbose
```

```shell
cd ../
```

```shell
cd frontend/front-app
```

```shell
npm run build
```

### Docker起動
```shell
docker compose up -d
```

### Dockerを停止したくなったら
```shell
docker compose down
```

### ビルドしたJarを適用
```shell
docker compose restart app
```