# PadraoIterator - Padrão de Projeto com Estruturas de Dados

## 📋 Descrição do Projeto

Este é um projeto educacional desenvolvido para estudar e praticar o **Padrão de Projeto Iterator** (Iterador), um dos padrões comportamentais mais importantes na orientação a objetos. O projeto implementa iteradores para diferentes estruturas de dados do Java, permitindo acessar elementos de uma coleção sequencialmente sem expor a representação interna da estrutura.

### O que é o Padrão Iterator?

O padrão Iterator fornece uma maneira de acessar elementos de uma coleção sequencialmente, sem expor a sua representação subjacente. Ele desacopla os algoritmos que operam sobre objetos das estruturas de dados que os contêm.

Neste projeto, cada estrutura de dados implementa diretamente a interface **`java.util.Iterator<Piloto>`** do Java, utilizando os métodos padrão `hasNext()` e `next()` em vez de uma interface customizada.

**Principais benefícios:**
- ✅ Acesso uniforme a diferentes estruturas de dados
- ✅ Encapsulamento da lógica de iteração
- ✅ Código cliente simplificado e desacoplado
- ✅ Compatibilidade nativa com a API padrão do Java

## 🏗️ Arquitetura do Projeto

O projeto implementa iteradores para cinco estruturas de dados diferentes:

| Iterador | Estrutura de Dados | Características |
|----------|-------------------|-----------------|
| **DequeIterador** | Deque (Double Ended Queue) | Acesso em ambas as extremidades |
| **FilaIterador** | Queue/Fila | FIFO (First In, First Out) |
| **MapIterador** | Map | Pares chave-valor |
| **PilhaIterador** | Stack/Pilha | LIFO (Last In, First Out) |
| **SetIterador** | Set | Coleção sem duplicatas |

### Estrutura de Diretórios

```
src/main/java/com/guisai/padraoiterator/
├── iteradores/           # Implementações dos iteradores (java.util.Iterator)
│   ├── DequeIterador.java
│   ├── FilaIterador.java
│   ├── MapIterador.java
│   ├── PilhaIterador.java
│   └── SetIterador.java
├── model/                # Modelos de dados
│   └── Piloto.java
├── service/              # Lógica de negócio
│   └── IteradoresService.java
├── ui/                   # Componentes de interface
│   └── OpcaoIterador.java
└── HelloApplication.java # Aplicação JavaFX

src/dados/
└── DadosDosPilotosF1.csv # Dados para teste
```

## 🚀 Como Usar

### Pré-requisitos
- **Java 21** ou superior
- **Maven 3.6** ou superior

### Como executar (Windows)

- Certifique-se que o JAVA_HOME existe como variável de ambiente
```powershell
$env:JAVA_HOME = 'C:\Caminho\Do\Java\...\jdk-21'
```

1. Abra o powershell na raiz do projeto (onde está o `pom.xml`).
1. Rode o comando abaixo para executar a aplicação diretamente:
```powershell
./mvnw clean javafx:run
```

### Compilar via IDE
- Abra o projeto em sua IDE (IntelliJ IDEA, Eclipse, VS Code + extensões)
- Clique em "Run" ou execute a classe `HelloApplication`

## 🛠️ Tecnologias Utilizadas

- **Java 21** - Linguagem de programação
- **Maven** - Gerenciador de dependências e build
- **JavaFX 21** - Framework para interface gráfica

## 📚 Funcionalidades

- ✨ Interface gráfica intuitiva com JavaFX
- 📖 Carregamento de dados de um arquivo CSV (pilotos de F1)
- 🔄 Seleção de diferentes estruturas de dados via Iterator
- 📊 Visualização sequencial dos dados através do padrão Iterator

## 💡 Exemplo de Uso

```java
// Criar um iterador específico (implementa java.util.Iterator<Piloto>)
Iterator<Piloto> iterador = new PilhaIterador(linhas);

// Iterar sobre os dados usando a API padrão do Java
while (iterador.hasNext()) {
    Piloto piloto = iterador.next();
    System.out.println(piloto);
}
```

## 📖 Aprendizados Práticos

Este projeto permite compreender:

1. **Encapsulamento** - Como abstrair a iteração de diferentes estruturas
2. **Interfaces** - Uso do contrato padrão `java.util.Iterator<T>`
3. **Polimorfismo** - Diferentes implementações do mesmo contrato
4. **Design Patterns** - Aplicação prática do padrão Iterator
5. **Processamento de Dados** - Leitura de CSV e manipulação de objetos

## 📝 Notas de Desenvolvimento

- O arquivo CSV está localizado em `src/dados/DadosDosPilotosF1.csv`
- Cada iterador implementa `java.util.Iterator<Piloto>` com os métodos padrão `hasNext()` e `next()`
- O serviço `IteradoresService` gerencia o carregamento, seleção do iterador e retorno dos dados para a UI
- A interface gráfica permite selecionar qual estrutura de dados deseja usar

---

**Autor:** GuiSai  
**Versão:** 1.0-SNAPSHOT  
**Data:** 2026
