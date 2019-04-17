LICENSE = "BSD & ( GPL-3.0 & The-Qt-Company-GPL-Exception-1.0 ) & ( GPL-2.0+ | LGPL-3.0 ) | The-Qt-Company-Commercial"
LIC_FILES_CHKSUM = " \
    file://LICENSE.GPL2;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
    file://LICENSE.GPL3;md5=d32239bcb673463ab874e80d47fae504 \
    file://LICENSE.GPL3-EXCEPT;md5=763d8c535a234d9a3fb682c7ecb6c073 \
    file://LICENSE.LGPL3;md5=e6a600fd5e1d9cbde2d983680233ad02 \
"

require qt5.inc
require qt5-git.inc

DEPENDS += "qtbase qtdeclarative qtremoteobjects-native"

# Patches from https://github.com/meta-qt5/qtremoteobjects/commits/b5.12
# 5.12.meta-qt5.2
SRC_URI += " \
    file://0001-Allow-a-tools-only-build.patch \
"

PACKAGECONFIG ??= ""
PACKAGECONFIG_class-native ??= "tools-only"
PACKAGECONFIG_class-nativesdk ??= "tools-only"
PACKAGECONFIG[tools-only] = "CONFIG+=tools-only"

EXTRA_QMAKEVARS_PRE += "${PACKAGECONFIG_CONFARGS}"

# Use 119b222dd5ee8f4410f87c5854e6e9ee65436309 instead of
# db1e447c46062946e57d7de9c0e0ea5fddc997f6 because the v5.12.3 tag wasn't
# merged to 5.12 branch yet
SRCREV = "119b222dd5ee8f4410f87c5854e6e9ee65436309"

BBCLASSEXTEND += "native nativesdk"
