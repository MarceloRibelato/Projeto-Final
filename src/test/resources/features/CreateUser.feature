#language: pt
#Author: Marcelo Ribelato
#Version: 1.0

@regressivo
Funcionalidade: Criar e editar contas de usuários
  Eu como Administrador do sistema, quero cadastrar e editar usuarios do sistema

  Cenario: Cadastrar novo usuário
    Dado que estou logado na api de cadastro
    Quando envio um requeste com dados validos
    Entao o usuario de ser casdatrado corretamente
    E o status code da criação de usuário deve ser 201

