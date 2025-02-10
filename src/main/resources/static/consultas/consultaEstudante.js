        document.addEventListener("DOMContentLoaded", function() {

            document.querySelectorAll(".btn-excluir").forEach(botao => {

                botao.addEventListener("click", function(event) {

                    event.preventDefault();

                    let idEstudante = this.getAttribute("data-id");

                    if (confirm("Tem certeza que deseja excluir este estudante?")) {
                        fetch("/estudante/deletar/" + idEstudante, {
                            method: "DELETE"
                        })
                        .then(response => {
                            if (response.ok) {
                                return response.text();
                            }
                            throw new Error("Erro ao deletar o estudante.");
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