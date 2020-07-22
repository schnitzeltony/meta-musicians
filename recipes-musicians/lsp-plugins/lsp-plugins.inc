SUMMARY = "LSP (Linux Studio Plugins) is a collection of open-source plugins"
HOMEPAGE = "http://lsp-plug.in/"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=3000208d539ec061b899bce1d9ce9404"

SRC_URI = " \
    gitsm://github.com/sadko4u/lsp-plugins.git \
    file://0001-Add-missing-dsp-in-SUBDIRS.patch \
"
SRCREV = "c95e356aee1c967f666823943553c21033d0b683"
S = "${WORKDIR}/git"
PV = "1.1.24"

do_configure[noexec] = "1"
