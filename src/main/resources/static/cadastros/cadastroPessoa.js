
        document.addEventListener("DOMContentLoaded", function() {

            let editando = document.getElementById("editando").value;

            if(editando == 'true'){
                let camposEditaveis = ["nomeCompleto", "email", "telefone"];

                            camposEditaveis.forEach(id => {
                                let campo = document.getElementById(id);
                                if (campo) {
                                    campo.removeAttribute("readonly");
                                    campo.removeAttribute("disabled");
                                }
                            });
            }
        });

        const formulario = document.getElementById('pessoaForm');

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
                    const confirmacao = confirm("Pessoa cadastrada com Sucesso!");
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

     function mascaraCPF(cpf) {
            cpf = cpf.replace(/\D/g, ''); // Remove tudo o que não é número
            cpf = cpf.replace(/^(\d{3})(\d{3})(\d{3})(\d{2})$/, '$1.$2.$3-$4');
            return cpf;
        }
        function aplicarMascaraCPF(event) {
            var campo = event.target;
            campo.value = mascaraCPF(campo.value);
        }

