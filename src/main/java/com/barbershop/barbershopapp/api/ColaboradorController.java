@RestController
@RequestMapping("/colaborador")
public class ColaboradorController {

    @Autowired
    private AgendamentoService agendamentoService;

    @Autowired
    private CalendarioService calendarioService;

    // Endpoint para listar agendamentos do colaborador
    @GetMapping("/{barbeiroNome}/agendamentos")
    public List<Agendamento> listarAgendamentos(@PathVariable String barbeiroNome) {
        return agendamentoService.listarAgendamentosPorBarbeiro(barbeiroNome);
    }

    // Endpoint para salvar dias "off" do colaborador
    @PostMapping("/{barbeiroId}/dias-off")
    public void salvarDiasOff(@PathVariable Long barbeiroId, @RequestBody List<LocalDate> diasOff) {
        agendamentoService.salvarDiasOff(barbeiroId, diasOff);
    }

    // Endpoint para verificar dias off no calendário do cliente
    @GetMapping("/{barbeiroId}/dias-off")
    public List<LocalDate> obterDiasOff(@PathVariable Long barbeiroId) {
        return calendarioService.getDiasOff(barbeiroId);
    }
}
