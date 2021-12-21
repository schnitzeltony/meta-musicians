SUMMARY = "LSP (Linux Studio Plugins) is a collection of open-source plugins"
HOMEPAGE = "http://lsp-plug.in/"
LICENSE = "LGPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=3000208d539ec061b899bce1d9ce9404"

SRC_URI = " \
    gitsm://github.com/sadko4u/lsp-plugins.git;branch=master;protocol=https \
    file://0001-Add-missing-dsp-in-SUBDIRS.patch \
"
SRCREV = "5ea0b02e08595a2fd2e29a1e0a2acf7189cce47a"
S = "${WORKDIR}/git"
PV = "1.1.31"

do_configure[noexec] = "1"
