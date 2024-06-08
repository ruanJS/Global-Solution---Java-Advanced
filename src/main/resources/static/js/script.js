document.addEventListener('DOMContentLoaded', function() {
    console.log('Script carregado com sucesso!');

    // Adicione aqui sua lógica JavaScript
    // Por exemplo:
    // 1. Selecionar elementos do DOM
    const content = document.querySelector('#content');

    // 2. Atualizar o conteúdo com base na página atual
    const path = window.location.pathname;
    switch (path) {
        case '/':
            content.innerHTML = '<h2>Bem-vindo ao OceanGuard Analytics!</h2><p>Este é o painel principal.</p>';
            break;
        case '/users':
            content.innerHTML = '<h2>Usuários</h2><p>Lista de usuários cadastrados.</p>';
            break;
        case '/observations':
            content.innerHTML = '<h2>Observações</h2><p>Lista de observações registradas.</p>';
            break;
        default:
            content.innerHTML = '<h2>Página não encontrada</h2><p>A página solicitada não existe.</p>';
    }
});
