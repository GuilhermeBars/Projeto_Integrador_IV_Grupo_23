# Configuração do MongoDB

## Para configurar a conexão com o MongoDB:

1. **Abra o arquivo:** `app/src/main/java/com/example/docnow/Constants.kt`

2. **Substitua `SUA_SENHA_AQUI` pela senha real do MongoDB Atlas**

3. **A senha deve ser a mesma para todos os membros da equipe**

## Exemplo:
```kotlin
const val MONGODB_CONNECTION_STRING = "mongodb+srv://docnowapp99_db_user:minhasenha123@docnowclusterdb.6nucg4g.mongodb.net/?retryWrites=true&w=majority&appName=DocNowClusterDB"
```

## ⚠️ IMPORTANTE:
- **NÃO commite a senha real no Git**
- **Substitua apenas localmente**
- **Compartilhe a senha com a equipe por outro meio (WhatsApp, Discord, etc.)**

## Como usar no código:
```kotlin
import com.example.docnow.Constants

val connectionString = Constants.MONGODB_CONNECTION_STRING
```
