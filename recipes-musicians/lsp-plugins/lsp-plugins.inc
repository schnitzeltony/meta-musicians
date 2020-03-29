SUMMARY = "LSP (Linux Studio Plugins) is a collection of open-source plugins"
HOMEPAGE = "http://lsp-plug.in/"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=3000208d539ec061b899bce1d9ce9404"

SRC_URI = " \
    gitsm://github.com/sadko4u/lsp-plugins.git \
    file://0001-Add-missing-dsp-in-SUBDIRS.patch \
"
SRCREV = "3f04d804912f6fa7fa978ba8e485d0718c49ffa1"
S = "${WORKDIR}/git"
PV = "1.1.15"

do_configure[noexec] = "1"
