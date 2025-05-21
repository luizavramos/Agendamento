CREATE TABLE IF NOT EXISTS usuario (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    senha VARCHAR(255) NOT NULL,
    tipo VARCHAR(20) NOT NULL,
    ativo BOOLEAN DEFAULT TRUE
);

CREATE TABLE IF NOT EXISTS consulta (
    id SERIAL PRIMARY KEY,
    paciente_id BIGINT NOT NULL,
    medico_id BIGINT NOT NULL,
    data_hora TIMESTAMP NOT NULL,
    observacoes TEXT,
    status VARCHAR(20) NOT NULL DEFAULT 'AGENDADA',
    criado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_paciente FOREIGN KEY(paciente_id) REFERENCES usuario(id),
    CONSTRAINT fk_medico FOREIGN KEY(medico_id) REFERENCES usuario(id)
);

CREATE TABLE IF NOT EXISTS notificacao (
    id SERIAL PRIMARY KEY,
    consulta_id BIGINT NOT NULL,
    mensagem TEXT NOT NULL,
    enviada_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_consulta FOREIGN KEY(consulta_id) REFERENCES consulta(id)
);