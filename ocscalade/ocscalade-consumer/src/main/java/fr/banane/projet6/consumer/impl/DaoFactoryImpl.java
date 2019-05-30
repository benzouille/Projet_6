package fr.banane.projet6.consumer.impl;

import fr.banane.projet6.consumer.contract.dao.DaoCommentaire;

import javax.inject.Inject;
import javax.inject.Named;

@Named("daoFactory")
public class DaoFactoryImpl {

    @Inject
    DaoCommentaire daoCommentaireImpl;
}
