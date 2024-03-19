package br.com.cotiinformatica.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import br.com.cotiinformatica.entities.Cliente;
import br.com.cotiinformatica.entities.Plano;
import br.com.cotiinformatica.factories.ConnectionFactory;

public class ClienteRepository {

	public void insert(Cliente cliente) throws Exception {

		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection
				.prepareStatement("insert into cliente(id, nome, email, telefone, plano_id) values(?,?,?,?,?)");

		statement.setObject(1, cliente.getId());
		statement.setString(2, cliente.getNome());
		statement.setString(3, cliente.getEmail());
		statement.setString(4, cliente.getTelefone());
		statement.setObject(5, cliente.getPlano().getId());
		statement.execute();

		connection.close();
	}

	public void update(Cliente cliente) throws Exception {

		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection
				.prepareStatement("update cliente set nome=?, email=?, telefone=?, plano_id=? where id=?");

		statement.setString(1, cliente.getNome());
		statement.setString(2, cliente.getEmail());
		statement.setString(3, cliente.getTelefone());
		statement.setObject(4, cliente.getPlano().getId());
		statement.setObject(5, cliente.getId());
		statement.execute();

		connection.close();
	}

	public void delete(Cliente cliente) throws Exception {

		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection.prepareStatement("delete from cliente where id=?");

		statement.setObject(1, cliente.getId());
		statement.execute();

		connection.close();
	}

	public List<Cliente> findAll() throws Exception {

		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection.prepareStatement
				("select c.id, c.nome, c.email, c.telefone, p.id as idplano, p.nome as nomeplano "
						+ "from cliente c inner join plano p on p.id = c.plano_id "
						+ "order by c.nome");

		ResultSet resultSet = statement.executeQuery();

		List<Cliente> lista = new ArrayList<Cliente>();

		while (resultSet.next()) {
			Cliente cliente = new Cliente();
			cliente.setPlano(new Plano());

			cliente.setId(UUID.fromString(resultSet.getString("id")));
			cliente.setNome(resultSet.getString("nome"));
			cliente.setEmail(resultSet.getString("email"));
			cliente.setTelefone(resultSet.getString("telefone"));
			cliente.getPlano().setId(UUID.fromString(resultSet.getString("idplano")));
			cliente.getPlano().setNome(resultSet.getString("nomeplano"));

			lista.add(cliente);

		}

		connection.close();
		return lista;
	}

	public Cliente findById(UUID id) throws Exception {

		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection.prepareStatement
				("select c.id, c.nome, c.email, c.telefone, p.id as idplano, p.nome as nomeplano "
						+ "from cliente c inner join plano p on p.id = c.plano_id "
						+ "where c.id = ?");
		statement.setObject(1, id);
		ResultSet resultSet = statement.executeQuery();

		Cliente cliente = null;

		if (resultSet.next()) {
			cliente = new Cliente();
			cliente.setPlano(new Plano());

			cliente.setId(UUID.fromString(resultSet.getString("id")));
			cliente.setNome(resultSet.getString("nome"));
			cliente.setEmail(resultSet.getString("email"));
			cliente.setTelefone(resultSet.getString("telefone"));
			cliente.getPlano().setId(UUID.fromString(resultSet.getString("idplano")));
			cliente.getPlano().setNome(resultSet.getString("nomeplano"));

		}
		
		connection.close();
		return cliente;
	}
}
