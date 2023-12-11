# projeto_ama
Construção de uma API Rest para gerenciamento de produtos que seguem as seguintes especificações:

O produto contém os seguintes dados:
- ID
- Nome
- Ativo
- SKU (código de identificação do produto)
- Categoria
- Valor de custo
- ICMS
- Valor de venda
- Imagem do produto
- Data de cadastro
- Quantidade em estoque

A categoria contém os seguintes dados:
- ID
- Nome
- Ativo
- Tipo (Normal, Especial, Personalizado)

Funcionalidades:  
1. Deve ser possível realizar as operações CRUD em um produto (Os cadastros de categoria e usuário podem ser feitas diretamente no banco, sem necessidade de CRUD específico).
2. O usuário pode inativar um produto ou excluir permanentemente.
3. Os produtos devem ser listados com paginação, com possibilidade de escolher a quantidade de itens por página e ordenação de todos os campos.
4. A listagem  deve permitir filtrar pelo usuário que cadastrou o produto.
5. A listagem deve permitir filtrar por múltiplos campos. Exemplo: filtrar por Nome, Nome e Categoria, Nome e Categoria e Data de cadastro. Deve ser possível filtrar por qualquer um dos campos.
6. O sistema deve permitir que o administrador crie uma regra para quais campos não serão exibidos para o estoquista. Exemplo: o administrador não quer exibir ICMS e Custo. O administrador pode alterar essa regra para os campos exibidos a qualquer momento.
7. O sistema deve ter um endpoint que liste os valores agregados dos produtos. Exemplo: Produto A - Custo: R$ 1,00 - Custo Total: R$ 10,00 - Quantidade: 10 - Valor Total Previsto: R$ 20,00. O endpoint deve filtrar da mesma forma que os itens 4 e 5.
8. O sistema deve emitir um relatório dos produtos em formato CSV ou XLSX (o usuário deve escolher qual formato), podendo filtrar os dados da mesma forma que os itens 4 e 5. O usuário, no momento da geração do relatório, poderá escolher quais campos do produto deseja exibir no relatório. Exemplo: todos, apenas ID e nome e SKU e etc.
9. O sistema deve registrar auditoria de todos os eventos realizados (criação, atualização, exclusão e etc.), registrando as seguintes informações: objeto alterado, ação realizada (inclusão, alteração, exclusão), data/hora e usuário que realizou a alteração. Deve ser possível detalhar a auditoria, mostrando o campo alterado, valor
anterior e valor atual. Exemplo:
Auditoria:
ID 39 - Produto - Inclusão - 10/10/2023 12:25 - Jose Carlos
ID 40 - Produto - Alteração - 10/10/2023 12:30 - João da Silva

Detalhamento auditoria ID 40:  
Campo: Nome - Valor anterior: Caixa SP - Valor atual: Caixa GR SP  
10. O usuário estoquista, na atualização de um produto, não deve alterar
o Valor de Custo e ICMS.  
11. Documente a API com Swagger.

Autenticação e Autorização
- A API deve utilizar a estratégia de autenticação JWT.
- Deve utilizar o conceito de refresh token, com um tempo de 5 minutos.
- O sistema deve ter dois níveis de acesso: administrador e estoquista.
- O sistema deve permitir que o administrador crie uma regra para quais campos não serão exibidos para o estoquista. Exemplo: o administrador não quer exibir ICMS e Custo. O administrador pode alterar essa regra para os campos exibidos a qualquer momento.
