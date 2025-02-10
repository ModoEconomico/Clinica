## João Vitor
- Testes, Usuarios e segurança


## Patricia
- Crud, Banco de dados e conexão com o banco de dados

## Padroes de projeto

- MVC
- Classes e sua nomeclatura
   - Exemplo: `UserController`, `UserEntity`, `UserRepository`, `UserModel`, `UserView`
- Conexão com o banco de dados
- Testes
- Segurança


Passos:
Clonar o repositório (se ainda não tiver)

bash
Copiar
Editar
git clone <URL_DO_REPOSITORIO>
cd <NOME_DO_REPOSITORIO>
Baixar as últimas mudanças da branch (se já tiver o repositório)

bash
Copiar
Editar
git pull origin <nome-da-branch>
Fazer minhas alterações no código

Adicionar e commitar as mudanças

bash
Copiar
Editar
git add .
git commit -m "Descrição do que foi alterado"
Baixar possíveis mudanças novas antes de enviar

bash
Copiar
Editar
git pull origin <nome-da-branch> --rebase
Se houver conflitos, resolvo manualmente e continuo com:
bash
Copiar
Editar
git add .
git rebase --continue
Enviar as alterações para o repositório

bash
Copiar
Editar
git push origin <nome-da-branch>