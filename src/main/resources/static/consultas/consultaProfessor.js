        document.addEventListener("DOMContentLoaded", function() {

            document.querySelectorAll(".btn-excluir").forEach(botao => {

                botao.addEventListener("click", function(event) {

                    event.preventDefault();

                    let idProfessor = this.getAttribute("data-id");

                    if (confirm("Tem certeza que deseja excluir este professor?")) {
                        fetch("/professor/deletar/" + idProfessor, {
                            method: "DELETE"
                        })
                        .then(response => {
                            if (response.ok) {
                                return response.text();
                            }
                            throw new Error("Erro ao deletar o professor.");
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