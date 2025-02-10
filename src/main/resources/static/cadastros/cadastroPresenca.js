
        const formulario = document.getElementById('presencaForm');

        formulario.addEventListener('submit', async function (evento) {
            evento.preventDefault();

            const formData = new FormData(formulario);

            try {
                const response = await fetch(formulario.action, {
                    method: 'POST',
                    body: formData,
                });
                if (response.ok) {
                    const result = await response.json();
                    const confirmacao = confirm("Presença cadastrada com Sucesso!");
                                if (confirmacao) {
                                    location.reload();
                               }
                } else {
                    alert('Houve um erro ao processar os dados.');
                }
            } catch (error) {
                alert('Não foi possível enviar os dados.');
            }
        });