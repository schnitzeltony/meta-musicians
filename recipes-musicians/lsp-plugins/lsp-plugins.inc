SUMMARY = "LSP (Linux Studio Plugins) is a collection of open-source plugins"
HOMEPAGE = "http://lsp-plug.in/"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=3000208d539ec061b899bce1d9ce9404"

SRC_URI = " \
    gitsm://github.com/sadko4u/lsp-plugins.git \
    file://0001-Remove-RPATHs.patch \
    file://0002-Add-missing-dsp-in-SUBDIRS.patch \
"
SRCREV = "543e17e9de3b8dc9de6e31438d1223d792054626"
S = "${WORKDIR}/git"
PV = "1.1.10"

do_configure[noexec] = "1"
