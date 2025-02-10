        document.addEventListener("DOMContentLoaded", function() {

            document.querySelectorAll(".btn-excluir").forEach(botao => {

                botao.addEventListener("click", function(event) {

                    event.preventDefault();

                    let idCurso = this.getAttribute("data-id");

                    if (confirm("Tem certeza que deseja excluir este curso?")) {
                        fetch("/curso/deletar/" + idCurso, {
                            method: "DELETE"
                        })
                        .then(response => {
                            if (response.ok) {
                                return response.text();
                            }
                            throw new Error("Erro ao deletar a curso.");
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