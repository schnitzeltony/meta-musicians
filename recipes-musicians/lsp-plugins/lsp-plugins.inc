SUMMARY = "LSP (Linux Studio Plugins) is a collection of open-source plugins"
HOMEPAGE = "http://lsp-plug.in/"
LICENSE = "LGPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=3000208d539ec061b899bce1d9ce9404"

SRC_URI = " \
    gitsm://github.com/sadko4u/lsp-plugins.git \
    file://0001-Add-missing-dsp-in-SUBDIRS.patch \
"
SRCREV = "d78befc2faaa6de64050c3c4b662dea429e47c40"
S = "${WORKDIR}/git"
PV = "1.1.30"

do_configure[noexec] = "1"

SECURITY_LDFLAGS = ""
