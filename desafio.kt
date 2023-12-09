enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        if (!inscritos.contains(usuario)) {
            inscritos.add(usuario)
            println("Matrícula realizada com sucesso para ${usuario.nome} na formação $nome.")
        } else {
            println("${usuario.nome} já possui inscrição na $nome.")
        }
    }
}

fun main() { 
    val conteudo1 = ConteudoEducacional("Introdução ao Kotlin", 60)
    val conteudo2 = ConteudoEducacional("Desenvolvendo Funções no Kotlin", 90)

    val formacaoKotlin = Formacao("Formação Kotlin", listOf(conteudo1, conteudo2))

    val usuario1 = Usuario("José")
    val usuario2 = Usuario("Bruno")

    // Simulação de cenários de teste
    formacaoKotlin.matricular(usuario1)
    formacaoKotlin.matricular(usuario2)
    formacaoKotlin.matricular(usuario1) // Tentativa de matricular o mesmo usuário novamente

    println("Alunos matriculados na formação ${formacaoKotlin.nome}: ${formacaoKotlin.inscritos.map { it.nome }}")
}