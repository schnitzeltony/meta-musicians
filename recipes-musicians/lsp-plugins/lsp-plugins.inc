SUMMARY = "LSP (Linux Studio Plugins) is a collection of open-source plugins"
HOMEPAGE = "http://lsp-plug.in/"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=3000208d539ec061b899bce1d9ce9404"

SRC_URI = " \
    git://github.com/sadko4u/lsp-plugins.git \
    file://0001-Remove-RPATHs.patch \
"
SRCREV = "04cc45a4aee3bd3a46ecbd0a9160d0d87f8f8a32"
S = "${WORKDIR}/git"
PV = "1.1.9"

do_configure[noexec] = "1"
