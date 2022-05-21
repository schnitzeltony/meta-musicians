SUMMARY = "A chorus audio effect plugin based on DSP code by Togu Audio Line (TAL)"
HOMEPAGE = "https://github.com/SpotlightKid/ykchorus"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=02ad2afd072e9ce4a370bedb49e2b075"

inherit pkgconfig gtk-icon-cache lv2-turtle-helper pack_audio_plugins

DEPENDS += " \
    liblo \
    jack \
    virtual/libgl \
"

SRC_URI = "gitsm://github.com/SpotlightKid/ykchorus.git;branch=master;protocol=https"
SRCREV = "6722568d5551b0f847083269cfbdfaa0f76b906f"
PV = "0.2.3"
S = "${WORKDIR}/git"

EXTRA_OEMAKE += " \
    PREFIX=${prefix} \
    NOOPT=true \
    SKIP_STRIPPING=true \
"

do_ttl_sed() {
    sed -i 's|${EXE_WRAPPER} "${GEN}" "./\x24{FILE}"|echo "`realpath  "./$FILE"`" >> ${LV2_PLUGIN_INFO_FILE}|g' ${S}/dpf/utils/generate-ttl.sh
}

do_install() {
    oe_runmake DESTDIR=${D} PREFIX=${prefix} LIBDIR=${libdir} install
}
