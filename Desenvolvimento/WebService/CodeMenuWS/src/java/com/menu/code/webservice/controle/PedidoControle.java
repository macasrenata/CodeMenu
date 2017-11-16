/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.menu.code.webservice.controle;

import com.menu.code.webservice.model.Pedido;
import com.menu.code.webservice.persistencia.PedidoDAO;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Marcio
 */
public class PedidoControle {
    
    @Autowired
    PedidoDAO pedidoDAO = new PedidoDAO();
    
    @GET
    @Path("/buscaPedidoId")
    @RequestMapping(value = "/pedidos", method = RequestMethod.GET,headers="Accept=application/json")
    public Pedido buscaPedidoId(Pedido pedido) throws Exception{       
        return pedidoDAO.carregar(pedido.getId());
    }
    
    @GET
    @Path("/listaPedidos")
    @RequestMapping(value = "/listaPedidos", method = RequestMethod.GET,headers="Accept=application/json")
    public List<Pedido> listaPedidos() throws Exception{       
        return pedidoDAO.listar();
    }
    
    @POST
    @Path("/adicionaPedido")
    @RequestMapping(value = "/adicionaPedido", method = RequestMethod.POST,headers="Accept=application/json")
    public ResponseEntity adicionaPedido(@RequestBody Pedido pedido) throws Exception{
        pedidoDAO.salvar(pedido);
        return new ResponseEntity(pedido, HttpStatus.OK);
    }        
    
    @PUT
    @Path("/atualizaPedido")
    @RequestMapping(value = "/atualizaPedido", method = RequestMethod.PUT,headers="Accept=application/json")
    public ResponseEntity atualizaPedido(@RequestBody Pedido pedido) throws Exception {
        pedidoDAO.atualizar(pedido);             
        return new ResponseEntity(pedido, HttpStatus.OK);
    }
}