//
// Created by Administrator on 2018/5/25.
//

#ifndef CTRLSDK_TEST_H
#define CTRLSDK_TEST_H

#include <stdio.h>
#include <string.h>

#include "include/openssl/aes.h"
#include "include/openssl/x509.h"
#include "FileUtil.h"

using namespace std;

class Encrypt {
public :
    static int encryptFile(string in_file_path, string out_file_path,
                                  const char *rc4_encrypt_key);

    static int decryptFile(string in_file_path, string out_file_path,
                                  const char *rc4_dencrypt_key);
};


#endif //CTRLSDK_TEST_H
