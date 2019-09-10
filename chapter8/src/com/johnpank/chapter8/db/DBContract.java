package com.johnpank.chapter8.db;

public class DBContract {

    public static final String DB_NAME = "dataBase";

    //clients
    public static final String CLIENT_TABLE_NAME = "clients";
    public static final String CLIENT_ID = "client_id";
    public static final String CLIENT_LOGIN = "login";
    public static final String CLIENT_PASSWORD = "password";
    public static final String CLIENT_TEL_NUMBER = "tel_number";
    public static final String CLIENT_EMAIL = "email";
    public static final String CLIENT_BIRTHDAY = "birthday";

    //account
    public static final String ACCOUNT_TABLE_NAME = "accounts";
    public static final String ACCOUNT_ID = "account_id";
    public static final String ACCOUNT_CLIENT_ID = "ac_cl_id";
    public static final String ACCOUNT_BALANCE = "balance";
    public static final String ACCOUNT_CREDIT = "credit";
    public static final String ACCOUNT_IS_BLOCKED = "is_blocked";

    /*
    create table accounts
		(
		id int auto_increment,
		ac_cl_id int not null,
		balance long,
		credit long,
		is_blocked boolean,
		constraint accounts_pk
		primary key (id),
		constraint accounts_CLIENTS_ID_fk
		foreign key (ac_cl_id) references CLIENTS
		)
     */

}
