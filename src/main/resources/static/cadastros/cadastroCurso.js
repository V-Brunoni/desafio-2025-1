
        const formulario = document.getElementById('cursoForm');

        formulario.addEventListener('submit', async function (evento) {
            evento.preventDefault(); // Evita o comportamento padrão de devolver um JSON

            const formData = new FormData(formulario);

            try {
                const response = await fetch(formulario.action, {
                    method: 'POST',
                    body: formData,
                });
                if (response.ok) {
                    const result = await response.json();
                    const confirmacao = confirm("Curso cadastrado com Sucesso!");
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