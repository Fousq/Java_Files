/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package kz.zhanbolat.files;


import kz.zhanbolat.files.serializable.Account;
import kz.zhanbolat.files.serializable.Balance;
import kz.zhanbolat.files.serializable.ForeignAccount;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.io.*;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class SerializableTest {
    private static final Logger logger = LogManager.getLogger(SerializableTest.class);
    private static final String SINGLE_OBJECT_FILE_NAME = "object.txt";
    private static final String OBJECTS_COLLECTION_FILE_NAME = "collection.txt";

    @Test
    public void testSingleObjectSerializationDeserialization() {
        Balance balance = new Balance("tenge", BigDecimal.valueOf(100), BigDecimal.valueOf(1.9));
        Account account = new Account(1L, "simple account", balance);

        URL resource = SerializableTest.class.getClassLoader().getResource(SINGLE_OBJECT_FILE_NAME);
        Objects.requireNonNull(resource);
        try (FileOutputStream fileOutputStream = new FileOutputStream(resource.getFile());
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(account);
        } catch (IOException e) {
            logger.error(e);
        }

        Account loadedAccount = null;
        try (FileInputStream fileInputStream = new FileInputStream(resource.getFile());
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            loadedAccount = (Account) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            logger.error(e);
        }

        logger.debug(loadedAccount);
        assertNull(loadedAccount.getId());
        assertEquals(account.getName(), loadedAccount.getName());
        assertEquals(account.getBalance(), loadedAccount.getBalance());
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testObjectsCollectionSerializationDeserialization() {
        List<Account> accountList = new ArrayList<>();
        Balance balance = new Balance("tenge", BigDecimal.valueOf(100), BigDecimal.valueOf(1.9));
        Account account1 = new Account(1L, "First account", balance);
        Account account2 = new Account(2L, "Second account", balance);
        accountList.add(account1);
        accountList.add(account2);

        URL resource = SerializableTest.class.getClassLoader().getResource(OBJECTS_COLLECTION_FILE_NAME);
        Objects.requireNonNull(resource);
        try (FileOutputStream fileOutputStream = new FileOutputStream(resource.getFile());
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(accountList);
        } catch (IOException e) {
            logger.error(e);
        }

        List<Account> loadedAccounts = new ArrayList<>();
        try (FileInputStream fileInputStream = new FileInputStream(resource.getFile());
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            loadedAccounts = (List<Account>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            logger.error(e);
        }

        logger.debug(loadedAccounts);
        assertEquals(accountList.size(), loadedAccounts.size());
        for (int i = 0; i < accountList.size(); i++) {
            Account account = accountList.get(i);
            Account loadedAccount = loadedAccounts.get(i);
            assertNull(loadedAccount.getId());
            assertEquals(account.getName(), loadedAccount.getName());
            assertEquals(account.getBalance(), loadedAccount.getBalance());
        }
    }

    @Test
    public void testSingleSubClassObjectSerializationDeserialization() {
        Balance balance = new Balance("RUB", BigDecimal.valueOf(100), BigDecimal.valueOf(1.9));
        ForeignAccount account = new ForeignAccount(1L, "simple account", balance, "Sberbank", "Russia");

        URL resource = SerializableTest.class.getClassLoader().getResource(SINGLE_OBJECT_FILE_NAME);
        Objects.requireNonNull(resource);
        try (FileOutputStream fileOutputStream = new FileOutputStream(resource.getFile());
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(account);
        } catch (IOException e) {
            logger.error(e);
        }

        ForeignAccount loadedAccount = null;
        try (FileInputStream fileInputStream = new FileInputStream(resource.getFile());
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            loadedAccount = (ForeignAccount) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            logger.error(e);
        }

        logger.debug(loadedAccount);
        assertNull(loadedAccount.getId());
        assertEquals(account.getName(), loadedAccount.getName());
        assertEquals(account.getBalance(), loadedAccount.getBalance());
        assertEquals(account.getBankName(), loadedAccount.getBankName());
        assertEquals(account.getCountry(), loadedAccount.getCountry());
    }

    @Test
    public void testSingleSubClassObjectSerializationDeserializationToSuperClass() {
        Balance balance = new Balance("RUB", BigDecimal.valueOf(100), BigDecimal.valueOf(1.9));
        ForeignAccount account = new ForeignAccount(1L, "simple account", balance, "Sberbank", "Russia");

        URL resource = SerializableTest.class.getClassLoader().getResource(SINGLE_OBJECT_FILE_NAME);
        Objects.requireNonNull(resource);
        try (FileOutputStream fileOutputStream = new FileOutputStream(resource.getFile());
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(account);
        } catch (IOException e) {
            logger.error(e);
        }

        Account loadedAccount = null;
        try (FileInputStream fileInputStream = new FileInputStream(resource.getFile());
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            loadedAccount = (Account) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            logger.error(e);
        }

        logger.debug(loadedAccount);
        assertNull(loadedAccount.getId());
        assertEquals(account.getName(), loadedAccount.getName());
        assertEquals(account.getBalance(), loadedAccount.getBalance());
    }
}
