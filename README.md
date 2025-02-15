## João Vitor
- Testes, Usuarios e segurança

--------------------
## Patricia
- Crud, Banco de dados e conexão com o banco de dados
------------------------
## Padroes de projeto

- MVC
- Classes e sua nomeclatura
   - Exemplo: `UserController`, `UserEntity`, `UserRepository`, `UserModel`, `UserView`
- Conexão com o banco de dados
- Testes
- Segurança

-------------------
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


--------------------------------------
## Simple Server

Para mapear as rotas para salvar entradas de dados no banco de dados sem usar uma estrutura e garantir que o servidor funcione ao executar o método `main`, siga estas etapas:

1. **Atualize a classe `SimpleHttpServer`**:
  - Adicione as importações necessárias.
  - Implementar a lógica do servidor HTTP.
  - Criar manipuladores para cada entidade (Paciente, Médico, Consulta).

2. **Modifique a classe `Main`**:
  - Inicie o servidor HTTP no método `main`.

### 1. Atualize a classe `SimpleHttpServer`

Adicione as importações necessárias e implemente a lógica do servidor HTTP. Crie manipuladores para cada entidade (Paciente, Médico, Consulta) para lidar com solicitações HTTP e salvar dados no banco de dados.

### 2. Modifique a classe `Main`

Atualize a classe `Main` para iniciar o servidor HTTP. Certifique-se de que o servidor seja iniciado quando o método `main` for executado e que ele lide com solicitações POST para os endpoints `/addPatient`, `/addDoctor` e `/addAppointment`, salvando os respectivos dados no banco de dados.

## Imports necessários

```java
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import com.joaovitor.entity.PatientEntity;
import com.joaovitor.controller.PatientController;
import com.joaovitor.entity.DoctorEntity;
import com.joaovitor.controller.DoctorController;
import com.joaovitor.entity.AppointmentEntity;
import com.joaovitor.controller.AppointmentController;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;