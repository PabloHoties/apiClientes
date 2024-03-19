package br.com.cotiinformatica.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import br.com.cotiinformatica.entities.Plano;
import br.com.cotiinformatica.factories.ConnectionFactory;

public class PlanoRepository {

	public List<Plano> findAll() throws Exception {
		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection.prepareStatement("select * from plano order by nome");

		ResultSet resultSet = statement.executeQuery();

		List<Plano> lista = new ArrayList<Plano>();

		while (resultSet.next()) {
			Plano plano = new Plano();

			plano.setId(UUID.fromString(resultSet.getString("id")));
			plano.setNome(resultSet.getString("nome"));

			lista.add(plano);
		}

		connection.close();
		return lista;
	}

	public Plano findById(UUID id) throws Exception {
		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection.prepareStatement("select * from plano where id=?");

		statement.setObject(1, id);

		ResultSet resultSet = statement.executeQuery();

		Plano plano = null;

		if (resultSet.next()) {
			plano = new Plano();
			plano.setId(UUID.fromString(resultSet.getString("id")));
			plano.setNome(resultSet.getString("nome"));
		}

		connection.close();
		return plano;
	}
}
