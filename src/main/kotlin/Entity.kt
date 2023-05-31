import jakarta.persistence.*

@Entity
data class Medicine (
    @Id
    @GeneratedValue
    val id: String,

    @Column(name = "назва")
    val назва: String,

    @Column(name = "лікарська_форма")
    val лікарськаФорма: String,

    @Column(name = "виробник")
    val виробник: String,

    @Column(name = "дата_виробництва")
    val датаВиробництва: String,

    @Column(name = "термін_зберігання")
    val термінЗберігання: String,

    @Column(name = "ціна")
    val ціна: String,

    @Column(name = "необхідність_рецепту")
    val необхідністьРецепту: String,

    @OneToOne
    @JoinColumn (name = "ліки_id")
    val medicine: Medicine = TODO()
)

