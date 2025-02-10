        document.addEventListener("DOMContentLoaded", function() {

            document.querySelectorAll(".btn-excluir").forEach(botao => {

                botao.addEventListener("click", function(event) {

                    event.preventDefault();

                    let idPessoa = this.getAttribute("data-id");

                    if (confirm("Tem certeza que deseja excluir esta pessoa?")) {
                        fetch("/pessoa/deletar/" + idPessoa, {
                            method: "DELETE"
                        })
                        .then(response => {
                            if (response.ok) {
                                return response.text();
                            }
                            throw new Error("Erro ao deletar a pessoa.");
                        })
                        .then(mensagem => {
                            alert(mensagem);
                            this.closest("tr").remove();
                        })
                        .catch(error => {
                            alert(error.message);
                        });
                    }
                });
            });
        });